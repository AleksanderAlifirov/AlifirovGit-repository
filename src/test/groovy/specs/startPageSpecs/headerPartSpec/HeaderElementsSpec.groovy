package specs.startPageSpecs.headerPartTest

import pages.RzdStartPage
import rzd.RzdSpec
import spock.lang.Stepwise

@Stepwise
class HeaderElementsSpec extends RzdSpec {

    def "Проверить корректное отображение элементов заголовка."() {
        given:
        открытьСтартовуюСтраницу()
        when:
        def view = at RzdStartPage
        then:
        view.Меню_Заголовка.О_Компании.displayed
        println "   Ссылка 'О компании' присутствует в заголовке."
        view.Меню_Заголовка.Контакты.displayed
        println "   Ссылка 'Контакты' присутствует в заголовке."
        view.Меню_Заголовка.Тендеры.displayed
        println "   Ссылка 'Тендеры' присутствует в заголовке."
        view.Меню_Заголовка.Пресс_Центр.displayed
        println "   Ссылка 'Пресс-центр' присутствует в заголовке."
        view.Меню_Заголовка.Инвесторам.displayed
        println "   Ссылка 'Инвесторам' присутствует в заголовке."
    }
}
