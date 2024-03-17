package org.code.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ActivityBooking {
    private final Activity activity;
    private final double price;
}