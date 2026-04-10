package com.github.ragingfirefy.tfctextoverlay.util;

import com.github.ragingfirefy.tfctextoverlay.common.Month;
import com.github.ragingfirefy.tfctextoverlay.common.Text;
import com.github.ragingfirefy.tfctextoverlay.text.*;
import net.dries007.tfc.client.ClientHelpers;
import net.dries007.tfc.client.ClimateRenderCache;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.calendar.Calendars;
import net.dries007.tfc.util.climate.KoppenClimateClassification;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class TerraFirmaCraftHelper {
    public static final String TEMPLATE_TEMPERATURE_SLICE_1 = "template.ftfctextoverlay.temperature.slice.1";
    public static final String TEMPLATE_TEMPERATURE_SLICE_2 = "template.ftfctextoverlay.temperature.slice.2";
    public static final String FORMAT_TEMPERATURE = "%.0f°C";
    public static final String TEMPLATE_RAINFALL_SLICE_1 = "template.ftfctextoverlay.rainfail.slice.1";
    public static final String TEMPLATE_RAINFALL_SLICE_2 = "template.ftfctextoverlay.rainfail.slice.2";
    public static final String FORMAT_RAINFALL = "%.0fmm";
    public static final String TEMPLATE_RAINFALL_PEAK_SLICE_1 = "template.ftfctextoverlay.rainfail.peak.slice.1";
    public static final String TEMPLATE_RAINFALL_PEAK_SLICE_2 = "template.ftfctextoverlay.rainfail.peak.slice.2";
    public static final String TEMPLATE_RAINFALL_PEAK_SLICE_3 = "template.ftfctextoverlay.rainfail.peak.slice.3";
    public static final String TEMPLATE_SEASON = "template.ftfctextoverlay.season";

    public static Month getTFCMonth() {
        net.dries007.tfc.util.calendar.Month tfcMonth = Calendars.get().getHemispheralCalendarMonthOfYear(ClientHelpers.inNorthernHemisphere());
        switch (tfcMonth) {
            case JANUARY -> {
                return Month.JANUARY;
            }
            case FEBRUARY -> {
                return Month.FEBRUARY;
            }
            case MARCH -> {
                return Month.MARCH;
            }
            case APRIL -> {
                return Month.APRIL;
            }
            case MAY -> {
                return Month.MAY;
            }
            case JUNE -> {
                return Month.JUNE;
            }
            case JULY -> {
                return Month.JULY;
            }
            case AUGUST -> {
                return Month.AUGUST;
            }
            case SEPTEMBER -> {
                return Month.SEPTEMBER;
            }
            case OCTOBER -> {
                return Month.OCTOBER;
            }
            case NOVEMBER -> {
                return Month.NOVEMBER;
            }
            case DECEMBER -> {
                return Month.DECEMBER;
            }
        }
        return Month.MARCH;
    }

    public static int getTFCDay() {
        return Calendars.CLIENT.getCalendarDayOfMonth();
    }

    public static List<Text> getTextList() {
        float avgTemp = ClimateRenderCache.INSTANCE.getAverageTemperature();
        float nowTemp = ClimateRenderCache.INSTANCE.getInstantTemperature();

        float avgRainfall = ClimateRenderCache.INSTANCE.getAverageRainfall();
        float nowRainfall = ClimateRenderCache.INSTANCE.getInstantRainfall();
        float rainVar = ClimateRenderCache.INSTANCE.getRainVariance();
        String peakRainfallTemplate = rainVar > 0 ? TEMPLATE_RAINFALL_PEAK_SLICE_3 : TEMPLATE_RAINFALL_PEAK_SLICE_2;
        float peakRainfall = avgRainfall * (1 + Math.abs(rainVar));

        Component month = getTFCMonth().getTranslate();
        Component season = getTFCMonth().toSeason().getTranslate();
        String day = String.valueOf(getTFCDay());
        Component climate = Helpers.translateEnum(KoppenClimateClassification.classify(avgTemp, avgRainfall, rainVar, ClientHelpers.inNorthernHemisphere()));

        List<Component> climateComponentList = List.of(climate);

        List<Component> tempComponentList = List.of(Component.translatable(TEMPLATE_TEMPERATURE_SLICE_1),
                Component.literal(String.format(FORMAT_TEMPERATURE, avgTemp)),
                Component.translatable(TEMPLATE_TEMPERATURE_SLICE_2),
                Component.literal(String.format(FORMAT_TEMPERATURE, nowTemp)),
                Component.literal("]"));

        List<Component> rainfallComponentList = List.of(Component.translatable(TEMPLATE_RAINFALL_SLICE_1),
                Component.literal(String.format(FORMAT_RAINFALL, avgRainfall)),
                Component.translatable(TEMPLATE_RAINFALL_SLICE_2),
                Component.literal(String.format(FORMAT_RAINFALL, nowRainfall)),
                Component.literal("]"));

        List<Component> rainfallPeakComponentList = List.of(Component.translatable(TEMPLATE_RAINFALL_PEAK_SLICE_1),
                Component.literal(String.format(FORMAT_RAINFALL, peakRainfall)),
                Component.translatable(peakRainfallTemplate));

        List<Component> seasonComponentList = List.of(season,
                Component.literal(", "),
                month,
                Component.translatable(TEMPLATE_SEASON, day));

        ArrayList<Text> list = new ArrayList<>();
        list.add(new ClimateText(climateComponentList));
        list.add(new TemperatureText(tempComponentList));
        list.add(new RainfallText(rainfallComponentList));
        list.add(new RainfallPeakText(rainfallPeakComponentList));
        list.add(new SeasonText(seasonComponentList));

        return list;
    }
}
