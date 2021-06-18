package com.labs.api.rest;

import com.labs.api.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/labs")
public class LabsController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping
    public ResponseEntity<String> getTest() throws InterruptedException {
        memoryService.simulateConsumeMemory();
        return ResponseEntity.status(HttpStatus.OK).body("TESTE");
    }

    @PostMapping("/memory/consume/{megaByteValue}")
    public ResponseEntity<Void> consume(@PathVariable("megaByteValue") Integer megaByteValue) {
        memoryService.simulateConsumeMemory(megaByteValue);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gc")
    public ResponseEntity<String> runGarbageCollector() throws InterruptedException {
        System.gc ();
        System.runFinalization ();
        return ResponseEntity.status(HttpStatus.OK).body("GC");
    }
}
