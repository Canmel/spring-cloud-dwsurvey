/**
 Copyright (c) 2011-2016, hubin (jobob@qq.com).
 <p>
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy of
 the License at
 <p>
 http://www.apache.org/licenses/LICENSE-2.0
 <p>
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 License for the specific language governing permissions and limitations under
 the License. */
package com.camel.oauth.server.utils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MysqlGenerator {
    public static void main(String[] args) {
        String path = new MysqlGenerator().getClass().getResource("/").getPath();
        path = path.substring(1, path.length() - 15);
        path += "src/main/java";

        com.baomidou.mybatisplus.generator.config.GlobalConfig config = new com.baomidou.mybatisplus.generator.config.GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/dw_oauth2?useSSL=false&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(new String[] {"sys_role", "sys_user_role", "sys_menu", "sys_role_menu"});
        config.setActiveRecord(false)
                .setEnableCache(false)
                .setAuthor(" * \n" +
                        " *   ┏ ┓   ┏ ┓\n" +
                        " *  ┏┛ ┻━━━┛ ┻┓\n" +
                        " *  ┃         ┃\n" +
                        " *  ┃    ━    ┃\n" +
                        " *  ┃  ┳┛  ┗┳ ┃\n" +
                        " *  ┃         ┃\n" +
                        " *  ┃    ┻    ┃\n" +
                        " *  ┃         ┃\n" +
                        " *  ┗━━┓    ┏━┛\n" +
                        " *     ┃    ┃神兽保佑\n" +
                        " *     ┃    ┃代码无BUG！\n" +
                        " *     ┃    ┗━━━━━━━┓\n" +
                        " *     ┃            ┣┓\n" +
                        " *     ┃            ┏┛\n" +
                        " *     ┗┓┓┏━━━━━━┳┓┏┛\n" +
                        " *      ┃┫┫      ┃┫┫\n" +
                        " *      ┗┻┛      ┗┻┛")
                // 这里就直接输出到项目里面，不用再复制进来
//                .setOutputDir("restful\\src\\main\\java")
                .setOutputDir(path)
                .setFileOverride(true)
                .setServiceName("%sService");
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent("com.camel.oauth.server")
                                .setController("controller")
                                .setEntity("com/camel/oauth/server/entity")
                ).execute();
    }
}
