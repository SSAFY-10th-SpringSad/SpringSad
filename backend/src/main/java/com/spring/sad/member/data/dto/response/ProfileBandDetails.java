package com.spring.sad.member.data.dto.response;

import com.spring.sad.band.domain.Band;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ProfileBandDetails {
    private long bandId;
    private String bandName;
    private String bandImg;
    public static ProfileBandDetails from(Band band) {
        return ProfileBandDetails.builder()
                .bandId(band.getBandId())
                .bandName(band.getBandName())
                .bandImg(band.getBandCover())
                .build();
    }
}
