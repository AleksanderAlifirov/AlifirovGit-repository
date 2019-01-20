package modules.header

import org.openqa.selenium.By
import rzd.RzdModule

class RzdHeader extends RzdModule {

    static content = {

        О_Компании { $("a[href*='://']", text: 'О компании' )}
        Пресс_Центр { find(By.xpath("//a[contains(text(), 'Пресс-центр')]")) }
        Инвесторам { find(By.xpath("//a[contains(text(), 'Инвесторам')]")) }
        Тендеры { find(By.xpath("//a[contains(text(), 'Тендеры')]")) }
        Контакты { find(By.xpath("//a[contains(text(), 'Контакты')]")) }
    }

}
