/*
 * Copyright (c) 2016 - 2018 Rui Zhao <renyuneyun@gmail.com>
 *
 * This file is part of Easer.
 *
 * Easer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Easer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Easer.  If not, see <http://www.gnu.org/licenses/>.
 */

package ryey.easer.plugins.event.calendar;

import android.support.annotation.NonNull;

import ryey.easer.commons.local_plugin.IllegalStorageDataException;
import ryey.easer.plugin.PluginDataFormat;
import ryey.easer.commons.local_plugin.ValidData;
import ryey.easer.commons.local_plugin.eventplugin.EventDataFactory;

class CalendarEventDataFactory implements EventDataFactory<CalendarEventData> {
    @NonNull
    @Override
    public Class<CalendarEventData> dataClass() {
        return CalendarEventData.class;
    }

    @ValidData
    @NonNull
    @Override
    public CalendarEventData dummyData() {
        CalendarData calendarData = new CalendarData();
        calendarData.calendar_id = 20;
        for (int i = 0; i < CalendarData.condition_name.length; i++) {
            if (i % 2 == 0) {
                calendarData.conditions.add(CalendarData.condition_name[i]);
            }
        }
        CalendarEventData dummyData = new CalendarEventData(calendarData);
        return dummyData;
    }

    @ValidData
    @NonNull
    @Override
    public CalendarEventData parse(@NonNull String data, @NonNull PluginDataFormat format, int version) throws IllegalStorageDataException {
        return new CalendarEventData(data, format, version);
    }
}
