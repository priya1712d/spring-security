/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.intercept;

import java.util.Collection;
import java.util.List;

import org.springframework.security.ConfigAttribute;


/**
 * Implemented by classes that store and can identify the {@link
 * ConfigAttribute}s that applies to a given secure object
 * invocation.
 *
 * @author Ben Alex
 * @version $Id$
 */
public interface ObjectDefinitionSource {
    //~ Methods ========================================================================================================

    /**
     * Accesses the <code>ConfigAttribute</code>s that apply to a given secure object.
     * <p>Returns <code>null</code> if no attributes apply.
     *
     * @param object the object being secured
     *
     * @return the attributes that apply to the passed in secured object
     *
     * @throws IllegalArgumentException if the passed object is not of a type supported by the
     *         <code>ObjectDefinitionSource</code> implementation
     */
    List<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException;

    /**
     * If available, returns all of the <code>ConfigAttribute</code>s defined by the implementing class.
     * <p>
     * This is used by the {@link AbstractSecurityInterceptor} to perform startup time validation of each
     * <code>ConfigAttribute</code> configured against it.
     *
     * @return the <code>ConfigAttribute</code>s or <code>null</code> if unsupported
     */
    Collection<ConfigAttribute> getAllConfigAttributes();

    /**
     * Indicates whether the <code>ObjectDefinitionSource</code> implementation is able to provide
     * <code>ConfigAttribute</code>s for the indicated secure object type.
     *
     * @param clazz the class that is being queried
     *
     * @return true if the implementation can process the indicated class
     */
    boolean supports(Class<?> clazz);
}
