package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class WeatherApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        com.example.weather.db.userinfoDB.connect();
        SpringApplication.run(WeatherApplication.class, args);
    }
}
/*TODO 实时天气查询：能够提供用户所在地区或指定地区的当前天气情况，包括温度、湿度、气压、风力、风向、天气状况等信息。
       天气预报查询：能够提供未来几天的天气预报，让用户了解未来天气情况，以便做好出行和穿着准备。
       城市切换：用户可以根据需要切换查询的城市，查询对应城市的天气情况。
       天气警报：如果有天气预警或紧急情况，系统应该能够及时提醒用户，让用户做出相应的应对措施。
       历史天气查询：用户可以查询过去某一段时间内的天气情况，以便做出决策或者了解天气变化趋势。
       天气图表和趋势分析：提供天气趋势图表，用户可以通过图表快速了解天气情况的变化趋势，以及对未来天气的预测。
       天气资讯：提供最新的天气资讯，如台风路径、气象灾害等，让用户随时掌握天气变化情况。
       天气分享：用户可以将当前天气情况分享到社交媒体上，让更多的人知道当地的天气情况。
       天气设置：用户可以根据个人喜好设置显示单位、语言和主题等。
       */