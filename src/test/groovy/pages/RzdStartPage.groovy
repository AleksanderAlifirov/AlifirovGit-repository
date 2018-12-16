package pages
import geb.Page
import modules.header.RzdHeader

class RzdStartPage extends Page {
    static at = { title == 'ОАО "РЖД"'}
    static content = {

        Меню_Заголовка { module RzdHeader }

    }

}