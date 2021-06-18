package com.labs.api.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class MemoryService {


    public void simulateConsumeMemory() throws InterruptedException {

        Vector v = new Vector();
        byte b[] = new byte[1048576 * 30];
        v.add(b);

    }

    public void simulateConsumeMemory(Integer megaByteValue) {

        Vector v = new Vector();
        byte b[] = new byte[1048576 * megaByteValue];
        v.add(b);

    }


}
