package com.marathon.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: hhx
 * @Date: 2024/4/23 04:20
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
public class VehicleInfo {
    private String make;
    private String model;
    private String color;
    private String licensePlate;
}
