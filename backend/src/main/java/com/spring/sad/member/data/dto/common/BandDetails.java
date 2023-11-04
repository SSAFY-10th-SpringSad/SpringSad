package com.spring.sad.member.data.dto.common;

import com.spring.sad.band.domain.Band;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class BandDetails {
    private long bandId;
    private String bandName;
    private String bandImg;
    public static BandDetails from(Band band) {
        return BandDetails.builder()
                .bandId(band.getId())
                .bandName(band.getBandName())
                .bandImg(band.getBandCover())
                .build();
    }
}
