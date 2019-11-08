package com.ovg.app.services;

import javax.transaction.Transactional;

public interface Fixture {
    @Transactional
    void load();
}
