/**
 * Copyright (C) 2014 Consorzio Roma Ricerche All rights reserved
 * This file is part of the Protocol Adapter software, available at https://github.com/theIoTLab/ProtocolAdapter .
 * The Protocol Adapter is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://opensource.org/licenses/LGPL-3.0
 * Contact Consorzio Roma Ricerche (protocoladapter@gmail.com)
 */

package eu.fistar.sdcs.pa.da.zephyrbh.utils;

import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * This class offers a facility method to convert time from format used by BioHarness to Unix Epoch.
 *
 * @author Marcello Morena
 * @author Alexandru Serbanati
 */
public class TimeConverter
{

  public static long timeToEpoch(int year, byte month, byte day, long millisOfDay)
  {

    int hours, minutes, seconds, milliseconds;
    long epoch;

    hours = (int)TimeUnit.MILLISECONDS.toHours(millisOfDay);
    minutes = (int)(TimeUnit.MILLISECONDS.toMinutes(millisOfDay) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisOfDay)));
    seconds = (int)(TimeUnit.MILLISECONDS.toSeconds(millisOfDay) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisOfDay)));
    milliseconds = (int)millisOfDay % 1000;

    epoch = new GregorianCalendar(year, ((int)month) - 1, (int)day, hours, minutes, seconds).getTimeInMillis();
    epoch += milliseconds;

    return epoch;
  }
}
