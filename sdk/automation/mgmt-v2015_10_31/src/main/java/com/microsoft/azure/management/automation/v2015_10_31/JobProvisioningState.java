/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.automation.v2015_10_31;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for JobProvisioningState.
 */
public final class JobProvisioningState extends ExpandableStringEnum<JobProvisioningState> {
    /** Static value Failed for JobProvisioningState. */
    public static final JobProvisioningState FAILED = fromString("Failed");

    /** Static value Succeeded for JobProvisioningState. */
    public static final JobProvisioningState SUCCEEDED = fromString("Succeeded");

    /** Static value Suspended for JobProvisioningState. */
    public static final JobProvisioningState SUSPENDED = fromString("Suspended");

    /** Static value Processing for JobProvisioningState. */
    public static final JobProvisioningState PROCESSING = fromString("Processing");

    /**
     * Creates or finds a JobProvisioningState from its string representation.
     * @param name a name to look for
     * @return the corresponding JobProvisioningState
     */
    @JsonCreator
    public static JobProvisioningState fromString(String name) {
        return fromString(name, JobProvisioningState.class);
    }

    /**
     * @return known JobProvisioningState values
     */
    public static Collection<JobProvisioningState> values() {
        return values(JobProvisioningState.class);
    }
}