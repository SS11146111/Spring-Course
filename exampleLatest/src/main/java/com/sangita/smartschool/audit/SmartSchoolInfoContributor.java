package com.sangita.smartschool.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmartSchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> smartMap = new HashMap<String, String>();
        smartMap.put("App Name", "SmartSchool");
        smartMap.put("App Description", "Smart School Web Application for Students and Admin");
        smartMap.put("App Version", "1.0.0");
        smartMap.put("Contact Email", "info@smartschool.com");
        smartMap.put("Contact Mobile", "+1(21) 673 4587");
        builder.withDetail("smartschool-info", smartMap);
    }

}
