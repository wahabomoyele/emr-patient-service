package com.orm.emrpatientservice.business.service;

import com.orm.emrpatientservice.Util.TestData;
import com.orm.emrpatientservice.business.exception.BadRequestException;
import com.orm.emrpatientservice.data.entity.Patient;
import com.orm.emrpatientservice.data.entity.entry.Entry;
import com.orm.emrpatientservice.data.repository.EntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Entry service tests")
public class EntryServiceUnitTest {
    @Mock
    EntryRepository entryRepository;

    @InjectMocks
    EntryService entryService;

    TestData testData;

    @BeforeEach
    void init() {
        entryService = new EntryService(entryRepository);
        testData = new TestData();
    }

    @Test
    void saveEntry() {
        when(entryRepository.save(any(Entry.class))).thenAnswer(f -> f.getArguments()[0]);
        Entry entry = entryService.saveEntry(testData.entryForm, testData.patient);
        assertNotNull(entry);
        assertEquals(entry.getTime().getMinute(), LocalDateTime.now().getMinute());
    }

    @Test
    void getPatientEntries() {
        when(entryRepository.findAllByPatient(any(Patient.class), any(Pageable.class))).thenReturn(Page.empty());
        assertNotNull(entryService.getPatientEntries(testData.patient, 0));
    }

    @Test
    void editEntry() {
        when(entryRepository.save(any(Entry.class))).thenAnswer(f -> f.getArguments()[0]);
        when(entryRepository.findById(any(UUID.class))).thenReturn(Optional.of(new Entry()));
        Entry entry = entryService.editEntry(UUID.randomUUID().toString(), "2020/12/11 14:45:32");
        assertNotNull(entry);
        Exception exception = assertThrows(BadRequestException.class, () -> entryService.editEntry(UUID.randomUUID().toString(), "2020/12/11"));
        assertNotNull(exception);
    }

    @Test
    void deleteEntry() {

    }


}
