/**********************************************************************
Copyright (c) 2014 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.store.types.converters;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Class to handle the conversion between java.time.LocalDateTime and java.util.Date.
 */
public class LocalDateTimeDateConverter implements TypeConverter<LocalDateTime, Date>
{
    private static final long serialVersionUID = -2827944255601470964L;

    public LocalDateTime toMemberType(Date date)
    {
        if (date == null)
        {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public Date toDatastoreType(LocalDateTime datetime)
    {
        if (datetime == null)
        {
            return null;
        }
        return Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
