package com.example.webtruyen.Core.Domain.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class TruyenTheLoaiKey implements Serializable {
    private Long theLoaiId;
    private Long truyenId;

    public TruyenTheLoaiKey(Long theLoaiId, Long truyenId) {
        this.theLoaiId = theLoaiId;
        this.truyenId = truyenId;
    }
}
