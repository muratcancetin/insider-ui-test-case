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
    OPEN_POSITION_PAGE_TITLE("Insider Open Positions | Insider");

    public String getTitle;
}
