package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TitleList {
    CAREERS_TITLE("Ready to disrupt? | Insider Careers"),
    HOMEPAGE_TITLE("#1 Leader in Individualized, Cross-Channel CX — Insider"),
    OPEN_POSITIONS("Insider Open Positions | Insider"),
    QUALITY_ASSURANCE_JOB_OPPORTUNITIES_TITLE("Insider quality assurance job opportunities");

    public String getTitle;
}
