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
    }
}
