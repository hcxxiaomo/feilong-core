/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.lang.reflect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.HttpMethodType;
import com.feilong.core.TimeInterval;
import com.feilong.test.User;
import com.feilong.tools.jsonlib.JsonUtil;

/**
 * The Class FieldUtilTest.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.0.7
 */
public class FieldUtilTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FieldUtilTest.class);

    /**
     * Test get static property.
     */
    @Test
    public void testGetStaticProperty(){
        assertEquals(HttpMethodType.POST, FieldUtil.getStaticFieldValue("com.feilong.core.net.HttpMethodType", "POST"));
        assertEquals(
                        TimeInterval.SECONDS_PER_WEEK,
                        FieldUtil.getStaticFieldValue("com.feilong.core.date.TimeInterval", "SECONDS_PER_WEEK"));
        //assertEquals(-1699987643831455524L, FieldUtil.getStaticFieldValue("com.feilong.core.bean.BeanUtilException", "serialVersionUID"));
    }

    /**
     * Creates the payment form.
     * 
     * @throws IllegalArgumentException
     *             the illegal argument exception
     * @throws IllegalAccessException
     *             the illegal access exception
     */
    @Test
    public void testGetFieldValueMap() throws IllegalAccessException{
        User user = new User(12L);
        LOGGER.info(JsonUtil.format(FieldUtil.getAllFieldNameAndValueMap(user)));
    }
}
