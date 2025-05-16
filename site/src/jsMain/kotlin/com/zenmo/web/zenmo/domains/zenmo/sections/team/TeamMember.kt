package com.zenmo.web.zenmo.domains.zenmo.sections.team

data class TeamMember(
    val name: String,
    val enTitle: String,
    val nlTitle: String,
    val image: String,
    val enShortBio: String,
    val nlShortBio: String,
    val email: String,
    val linkedIn: String,
    val twitter: String? = null,
)

// todo get socials and photos of team members
// also i'd prefer to have a max of 2 sentences(what you do and interests/hobbies)
// in the short bio, so that it fits nicely on the card

val ZenmoTeam = listOf(
    TeamMember(
        name = "Auke Hoekstra",
        enTitle = "Director & founder",
        nlTitle = "Directeur & oprichter",
        image = "avatars/Auke_Hoekstra.jpg",
        enShortBio =
            """
                After 20 years of experience as an independent consultant, Auke has been researching sustainable energy and electric mobility for 15 years now. 
                He has written books and articles about it, gives lectures and advises. Above all, he is the inventor of the ZEnMo approach and gives direction to its further development.
            """.trimIndent(),
        nlShortBio =
            """
                Na 20 jaar ervaring als zelfstandig adviseur, is Auke al 15 jaar bezig met onderzoek naar duurzame energie en elektrische mobiliteit. 
                Hij heeft er boeken en artikelen over geschreven, geeft lezingen en adviseert. Bovenal is hij de uitvinder van de ZEnMo aanpak en geeft daar richting aan de verdere ontwikkeling.
            """.trimIndent(),
        email = "auke@zenmo.com",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Peter Hogeveen",
        enTitle = "Technical Director & Co-Founder",
        nlTitle = "Technisch Directeur & Co-Founder",
        image = "avatars/peter-hoogeveen.jpg",
        enShortBio =
            """
                Peter studied applied physics and has experience as an electric transport consultant. 
                This has led to his current PhD research at Eindhoven University of Technology on transition models for energy and mobility systems. 
                He applies that knowledge in the ZEnMo models.
            """.trimIndent(),
        nlShortBio =
            """
                Peter studeerde toegepaste natuurkunde en heeft ervaring als consultant elektrische transport. 
                Dit heeft geleid tot zijn huidige promotieonderzoek aan de Technische Universiteit Eindhoven naar transitiemodellen voor energie- en mobiliteitssystemen.
                Hij past die kennis toe in de ZEnMo-modellen.
            """.trimIndent(),
        email = "peter@zenmo.com",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Naud Loomans",
        enTitle = "Modeller, marketing & website",
        nlTitle = "Modeller, marketing & website",
        image = "avatars/Loomans_Naud.jpg",
        enShortBio =
            """
                Naud studied innovation sciences and specialized in sustainable energy. 
                When he graduated, he very successfully developed the ZEnMo Zero model for the province of North Brabant. 
                His strength lies in understanding both the technical side and the stakeholders in shaping innovative sustainable scenarios.
            """.trimIndent(),
        nlShortBio =
            """
                Naud studeerde innovatiewetenschappen en specialiseerde zich in duurzame energie. 
                Bij zijn afstuderen ontwikkelde hij zeer succesvol het ZEnMo Zero-model voor de provincie Noord-Brabant. 
                Zijn kracht ligt in het begrijpen van zowel de technische kant als de belanghebbenden bij het vormgeven van innovatieve duurzame scenario's.
            """.trimIndent(),
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Maarten Steinbuch",
        enTitle = "Smart mobility professor & co-founder",
        nlTitle = "Professor slimme mobiliteit & co-founder",
        image = "avatars/Maarten-Steinbuch.jpg",
        enShortBio =
            """
                As the driving force behind the automotive master's program at TU/e, Maarten knows all about smart electric cars and trucks. 
                But also in terms of modelling, he and his system control department are of great value to ZEnMo. 
                In addition to being an unstoppable dynamo, we see it as our technical conscience.
            """.trimIndent(),
        nlShortBio =
            """
                Als drijvende kracht achter de masteropleiding automotive aan de TU/e weet Maarten alles van slimme elektrische auto's en vrachtwagens. 
                Maar ook op het gebied van modelleren zijn hij en zijn systeemcontrole-afdeling van grote waarde voor ZEnMo. 
                Naast een niet te stoppen dynamo zien we het als ons technisch geweten.
            """.trimIndent(),
        email = "",
        linkedIn = "",
    ),
    TeamMember(
        name = "Peter Molengraaf",
        enTitle = "Energy transition expert & co-founder",
        nlTitle = "Energietransitie-expert & co-founder",
        image = "avatars/Peter_molengraaf.jpg",
        enShortBio =
            """
                As the ex-CEO of grid operator Alliander, Peter was at the forefront of many sustainable initiatives in the Netherlands. 
                Auke and he once planned to write a book about what the energy transition would look like, but this is one step further. 
                Peter helps ZEnMo to think in terms of added value at board level.
            """.trimIndent(),
        nlShortBio =
            """
                Als ex-CEO van netbeheerder Alliander was Peter betrokken bij veel duurzame initiatieven in Nederland. 
                Auke en hij hebben ooit het plan gehad om een boek te schrijven over hoe de energietransitie eruit zou zien, maar dit is een stap verder. 
                Peter helpt ZEnMo om in termen van toegevoegde waarde op bestuursniveau te denken.
            """.trimIndent(),
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Iris Hoekstra",
        enTitle = "Assistant",
        nlTitle = "Assistent",
        image = "avatars/Iris-Hoekstra.jpg",
        enShortBio =
            """
                After a versatile career (including as a programmer of web applications), Iris joined Zenmo in the summer of 2022. 
                Iris provides administrative and organizational support and is Auke's personal assistant.
            """.trimIndent(),
        nlShortBio =
            """
                Na een veelzijdige carrière (waaronder als programmeur van webapplicaties) is Iris in de zomer van 2022 bij Zenmo gekomen. 
                Iris biedt administratieve en organisatorische ondersteuning en is Auke's persoonlijke assistent.
            """.trimIndent(),
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Gillis Hommen",
        enTitle = "Energy Systems Modeler",
        nlTitle = "Energiesystemen modelleur",
        image = "avatars/Gillis-Hommen.jpg",
        enShortBio =
            """
                After his master's and PhD Control Systems Technology at TU/e, where he developed a camera system for the control of nuclear fusion reactors, 
                Gillis worked at various companies in the automotive and high-tech systems sector. 
                That knowledge and experience, together with a healthy dose of interest in our energy supply and an intrinsic motivation to help the world move forward, 
                form the ideal baggage for the role of modeler at ZEnMo Simulations.
            """.trimIndent(),
        nlShortBio =
            """
                Na zijn master en PhD Control Systems Technology aan de TU/e, waar hij een camerasysteem ontwikkelde voor de regeling van kernfusie-reactoren, 
                werkte Gillis bij verschillende bedrijven in de automotive en hightech systemen sector. 
                Die kennis en ervaring, samen met een gezonde dosis interesse in onze energievoorziening en een intrinsieke motivatie om de wereld vooruit te helpen, 
                vormen de ideale bagage voor de rol van modelleur bij ZEnMo Simulations.
            """.trimIndent(),
        email = "",
        linkedIn = "",
    ),
    TeamMember(
        name = "Ate Hempenius",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "avatars/blank.png",
        enShortBio = "",
        nlShortBio = "",
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Luc-Sol",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "avatars/blank.png",
        enShortBio = "",
        nlShortBio = "",
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Thijs Ratsma",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "avatars/blank.png",
        enShortBio = "",
        nlShortBio = "",
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Erik van Velzen",
        enTitle = "Software Developer",
        nlTitle = "Software ontwikkelaar",
        image = "avatars/Erik.jpg",
        enShortBio =
            """
                Erik has 10 years of experience in developing business applications. 
                At Zenmo, he links the simulations to external systems and data sources. 
                He also gives the simulations a user-friendly and attractive shell to appeal to a wider audience.
            """.trimIndent(),
        nlShortBio =
            """
                Erik heeft 10 jaar ervaring in het ontwikkelen van bedrijfsapplicaties. 
                Bij Zenmo koppelt hij de simulaties aan externe systemen en gegevensbronnen.
                Ook geeft hij de simulaties een gebruiksvriendelijke en aantrekkelijke schil om een breder publiek aan te spreken.
            """.trimIndent(),
        email = "",
        linkedIn = "",
        twitter = "",
    ),
    TeamMember(
        name = "Vincent Kofi K.",
        enTitle = "Software Developer",
        nlTitle = "Software ontwikkelaar",
        image = "avatars/blank.png",
        enShortBio = "",
        nlShortBio = "",
        email = "",
        linkedIn = "",
        twitter = "",
    ),
)