# SpringCloud 微服务构建

## 微服务各组件
### 一. SpringCloud-base-core
*这部分是一些核心类*
**实体类**
> 如`Result`返回结果类，`BasePaginationEntity` 分页实体类，需要分页的类需要继承 , `BaseEntity`实体类基类。

**枚举类**
> 关于结果的枚举类型 `ResultEnum`

**工具类**
> 分页，结果集等工具类 `ResultUtil`, `PaginationUtil` ...

**控制器基类**
> 普通单表增删改查继承 `BaseCommonController`

### 二. springcloud-eureka-server
*eureka server 服务， 搭建服务注册中心*

**服务注册中心端口** ： `8888`

**服务注册名称** ：`eureka-server`

### 三. springcloud-oauth-resource
*oauth2 资源服务器*

### 四. springcloud-oauth-resource-system
*oauth2 资源服务器-系统服务*

### 五. springcloud-oauth-server
*oauth2 授权服务器*

### 六. springcloud-zuul-getway
*zuul getway, oauth2 资源服务器*

**路由**
```yml
    resource:
      path: /api/**
      url: http://127.0.0.1:9000
    system:
      path: /system/**
      url: http://127.0.0.1:9001
    user: 
      path: /user/**
      url: http://127.0.0.1:9000/user
    auth:
      path: /auth/**
      url: http://127.0.0.1:7070
```

**工作顺序**

如访问 资源服务器： `springcloud-oauth-resource-system` 

路径`/sysUser`

请求方式 `GET`
> 1. 通过zuul配置的路径 `system`, url为 `http://127.0.0.1:8080/system/sysUser`
> 2. zuul 会将请求转发至 `springcloud-oauth-resource-system`项目
> 3. 在未登录状态，`springcloud-oauth-resource-system`会返回401，没有权限
> 4. zuul网关会请求 `授权服务器` 登录，获取授权
> 5. 授权服务器已经设置了登录页面 `.formLogin().loginPage("/login");`
> 6. 授权服务器请求统一登录页面 `springcloud-oauth-server` 的 `/login`页面
> 7. 填写用户名密码后获取授权信息，返回`zuul`网关
> 8. zuul网关有了认证信息后，再次通过网关访问资源服务器
> 9. 资源服务器返回结果