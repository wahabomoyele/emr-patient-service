package com.orm.emrpatientservice.data.entity.entry;

import com.orm.emrpatientservice.data.entity.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@MappedSuperclass
public class EntryItem extends BaseEntity {
    @NotNull
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID entryId;


    public UUID getEntryId() {
        return entryId;
    }

    public void setEntryId(UUID entryId) {
        this.entryId = entryId;
    }
}
