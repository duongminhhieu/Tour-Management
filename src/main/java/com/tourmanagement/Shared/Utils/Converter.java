package com.tourmanagement.Shared.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tourmanagement.Models.SightseeingSpot;

import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.Date;
import java.util.List;

public class Converter {
    public static List<String> convertJsonImagesToListImages(String jsonImages) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();

        return gson.fromJson(jsonImages, listType);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertListSightSeeingToJson(List<String> idSightseeingList) {
        try {
            return objectMapper.writeValueAsString(idSightseeingList);
        } catch (JsonProcessingException e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
            return null; // hoặc throw một ngoại lệ khác tùy thuộc vào yêu cầu của bạn
        }
    }

    public static List<String> convertJsonIDToListSightSeeing(String jsonID) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();

        return gson.fromJson(jsonID, listType);
    }


    public static String convertListImagesToJson(List<String> images) {
        Gson gson = new Gson();
        return gson.toJson(images);
    }

    public static java.sql.Date convertDateUtilToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static String convertVietnameseToUnsigned(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
