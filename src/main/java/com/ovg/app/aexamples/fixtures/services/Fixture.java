package com.ovg.app.aexamples.fixtures.services;

import javax.transaction.Transactional;

public interface Fixture {
    @Transactional
    void load();
}
