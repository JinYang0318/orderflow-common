package com.orderflow_common.orderflow_common.Util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.orderflow_common.orderflow_common.constant.UtilityConstant.SYSTEM_TIMEZONE;

public class DateTimeUtils {
    private DateTimeUtils() {
        throw new IllegalStateException("DateTimeUtils class");
    }

    public static OffsetDateTime getCurrentOffsetDateTime() {
        return OffsetDateTime.now()
                .withOffsetSameInstant(ZoneOffset.of(SYSTEM_TIMEZONE));
    }

}
