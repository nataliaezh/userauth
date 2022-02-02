package com.mesh.userauth.config;


import com.mesh.userauth.entity.Profile;
import com.mesh.userauth.repository.ProfileRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Config {
    private ProfileRepository profileRepository;

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Bean
    public GroupedOpenApi publicUserApi() {
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("Swagger user auth app")String appDescription,
                                 @Value("Version 1.0")String appVersion) {
        return new OpenAPI().info(new Info().title("User auth app")
                        .version(appVersion)
                        .description(appDescription));
    }

    @Scheduled(fixedDelay = 20000)
    public void scheduleFixedDelayTask() {
        Profile profile = new Profile();
        double cash = profile.getCash();
            final double value = cash;
            var buf = 0.0;
            int i = 0;
            while (cash < (value * 107)/100) {
                cash *= 1.1;
            }
            buf = Math.round(cash * 100.0) / 100.0;


            profile.setCash((double)buf);
            profileRepository.save(profile);
            double cashFromBD = profileRepository.findById(profile.getId()).get().getCash();
           }
    }

