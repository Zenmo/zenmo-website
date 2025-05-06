package com.zenmo.web.zenmo.components.sections.home.components

data class LuxProduct(
    val productTitle: String,
    val enDescription: String,
    val nlDescription: String,
)


val LuxProducts = listOf(
    LuxProduct(
        productTitle = "LUX Company",
        enDescription =
            """
                More companies are discovering they can grow their business with batteries, 
                even if the grid operator does not make extra capacity available. LUX Company provides accurate 
                insight into what a battery, of what size and price can bring to your company.
                """.trimIndent(),
        nlDescription =
            """
                Steeds meer bedrijven ontdekken dat ze hun bedrijf kunnen laten groeien met batterijen, zelfs 
                als de netbeheerder geen extra capaciteit beschikbaar stelt. LUX Company geeft nauwkeurig inzicht in 
                wat een batterij, van welke grootte en prijs voor uw bedrijf kan betekenen.
                """.trimIndent(),
    ),
    LuxProduct(
        productTitle = "LUX Energy Hub",
        enDescription =
            """
                LUX Energy Hub helps business parks tackle grid congestion by showing how companies can collaborate 
                using shared solutions like common batteries, group contracts (GTO), or local heat networks.
                """.trimIndent(),
        nlDescription =
            """
                LUX Energy Hub helpt bedrijventerreinen bij het aanpakken van netcongestie door te 
                laten zien hoe bedrijven kunnen samenwerken met behulp van gedeelde oplossingen zoals 
                gemeenschappelijke batterijen, groepscontracten (GTO) of lokale warmtenetten.
                """.trimIndent(),
    ),
    LuxProduct(
        productTitle = "LUX Residential Area",
        enDescription =
            """
                LUX Residential Area provides solutions for getting residential areas off gas, reducing energy costs, 
                and addressing grid congestion through heat networks or hybrid heat pumps.
                """.trimIndent(),
        nlDescription =
            """
                LUX Residential Area biedt oplossingen om woonwijken van het gas af te krijgen, de energiekosten te 
                verlagen en congestie op het net aan te pakken door middel van warmtenetten of hybride warmtepompen.
                """.trimIndent()
    ),
    LuxProduct(
        productTitle = "LUX Municipality, RES, and Province",
        enDescription =
            """
                LUX Municipality, RES, and Province support provinces and municipalities in forming energy hubs, 
                offering dynamic simulations to calculate scenarios for sustainable development
                """.trimIndent(),
        nlDescription =
            """
            Gemeente LUX, RES en provincie ondersteunen provincies en gemeenten bij het vormen van energiehubs en 
            bieden dynamische simulaties om scenario's voor duurzame ontwikkeling door te rekenen
            """.trimIndent(),
    )
)
