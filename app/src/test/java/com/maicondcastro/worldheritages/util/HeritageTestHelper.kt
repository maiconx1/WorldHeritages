package com.maicondcastro.worldheritages.util

import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal
import com.maicondcastro.worldheritages.heritage.domain.entity.Heritage

interface HeritageTestHelper {

    fun createHeritageLocal() = HeritageLocal(
        coordinates = COORDINATES,
        id = ID,
        image = IMAGE,
        imageAuthor = IMAGE_AUTHOR,
        lat = LAT,
        lng = LNG,
        longInfo= LONG_INFO,
        name = NAME,
        page = PAGE,
        region = REGION,
        regionLong = REGION_LONG,
        shortInfo = SHORT_INFO,
        target = TARGET,
        type = TYPE,
        year = YEAR
    )

    fun createHeritageDomain() = Heritage(
        coordinates = COORDINATES,
        id = ID,
        image = IMAGE,
        imageAuthor = IMAGE_AUTHOR,
        lat = LAT,
        lng = LNG,
        longInfo= LONG_INFO,
        name = NAME,
        page = PAGE,
        region = REGION,
        regionLong = REGION_LONG,
        shortInfo = SHORT_INFO,
        target = TARGET,
        type = TYPE,
        year = YEAR
    )

    fun createHeritageDomainList() = listOf(createHeritageDomain())

    fun createHeritageLocalList() = listOf(createHeritageLocal())

    companion object {
        const val COORDINATES = "S20 23 20 W43 30 20"
        const val ID = "124"
        const val IMAGE = "http://whc.unesco.org//uploads/thumbs/site_0124_0006-750-0-20121218171636.jpg"
        const val IMAGE_AUTHOR = "Colonial houses; City of Ouro Preto, State of Minas Gerais; Brazil; UNESCO World Heritage SiteMaisons coloniales; Ville de Ouro Preto; Etat de Minas Gerais; Brésil; Site du Patrimoine Mondial de l’UNESCOKolonialhäuser der Stadt Ouro Preto; Staat Minas Gerais; Brasilien; Welterbe UNESCO © M & G Therin-Weise"
        const val LAT = -20.38888888888889
        const val LNG = -43.50555555555555
        const val LONG_INFO = "Located 513 km north of Rio de Janeiro, Ouro Preto (Black Gold) was the main focal point of the period known as the Golden Age of Brazil. Originally called Vila Rica, this city played a leading role in Brazil's history in the 18th century. It was created by thousands of soldiers of fortune eager to enrich themselves by exploiting the gold deposits; they were followed by many artists who came to settle and produce works of outstanding quality, such as the São Francisco of Assis church by Antonio Francisco Lisboa (Aleijadinho).\\n\\nOuro Preto, the old capital of Minas Gerais, owes its origins to the discovery and exploitation of the gold. The creation in 1698 of the Capitania de São Paulo e Minas do Ouro resulted in the earlier mining settlements being transformed into villas (small towns), the second of which was Vila Rica, in 1712. Minas Gerais became an independent Capitania in 1720, with Vila Rica as its capital. The growth of the town was rapid as a result of the rich mineral resources, and it developed its own urban features characteristic of a mining town. In the closing years of the 18th century it became a centre of the movement for the emancipation of Brazil from colonial rule known as Inconfidência Mineira. A rapid decline in mineral resources and mining resulted in a deterioration in the economy of this part of the province. In 1823 its status was changed to that of an imperial town, with the new name of Ouro Preto and this attracted a number of higher education establishments, but with the transfer of the provincial capital in 1897 to Belo Horizonte the fortunes of Ouro Preto declined again. Since the 1930s it has been principally a tourist centre.\\n\\nThe town was shaped by the grouping together of small settlements (arriais) in a hilly landscape, where the houses, mostly single- or two-storeyed, seem to support one another, forming an irregular urban layout that follows the contours of the landscape. However, the resources derived from mining, coupled with the talents of artists such as Aleijadinho and others, some outstanding architectural and artistic masterpieces are to be found. A 'Mining Baroque' style developed in the second half of the 18th century which successfully fused Brazilian influences with European Baroque and Rococo.\\n\\nThe Church of Saõ Francisco de Assis is considered to be a masterpiece of Brazilian architecture. Ouro Preto also boasts a number of other fine churches and secular buildings such as the churches of Our Lady of the Pillar, the Rosário dos Homens Pretos, the Virgin of the Conceição, and the Virgin of Carmel, the House of the Baroness, the chafarizes of the High Da Cruz and Alto of the Heads.\\n\\nTiradentes Square is the main point from which all the roads diverge. Around it are situated imposing public and private buildings, such as the old Parliament House (1784), today the Museum of the Inconfidência, and the Palace of the Governors, which has become the School of Mines and Metallurgy.\\n\\nThe townscape of Ouro Preto is also noteworthy for its bridges and fountains, all blending into an urban and natural setting of great beauty."
        const val NAME = "Historic Town of Ouro Preto"
        const val PAGE = "http://whc.unesco.org/en/list/124"
        const val REGION = "LAC"
        const val REGION_LONG = "Latin America and the Caribbean"
        const val SHORT_INFO = "Historic Town of Ouro Preto\\n\\nFounded at the end of the 17th century, Ouro Preto (Black Gold) was the focal point of the gold rush and Brazil’s golden age in the 18th century. With the exhaustion of the gold mines in the 19th century, the city’s influence declined but many churches, bridges and fountains remain as a testimony to its past prosperity and the exceptional talent of the Baroque sculptor Aleijadinho."
        const val TARGET = "BRA"
        const val TYPE = "Cultural"
        const val YEAR = 1980
    }
}