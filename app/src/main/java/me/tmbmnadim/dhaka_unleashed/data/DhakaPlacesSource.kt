package me.tmbmnadim.dhaka_unleashed.data

import me.tmbmnadim.dhaka_unleashed.R
import me.tmbmnadim.dhaka_unleashed.models.DhakaPlace

object DhakaPlacesSource {
    val places = listOf(
        DhakaPlace(
            image = R.drawable.lalbagh_fort,
            title = "Lalbagh Fort",
            subtitle = "Mughal-era fortress",
            description = "An incomplete 17th-century Mughal fort complex built by Prince Muhammad Azam, featuring the tomb of Bibi Pari, a mosque, and beautifully landscaped gardens. It's one of the most iconic historical landmarks in Old Dhaka."
        ),
        DhakaPlace(
            image = R.drawable.ahsan_monjil,
            title = "Ahsan Manzil",
            subtitle = "The Pink Palace",
            description = "Once the official residential palace of the Nawab of Dhaka, this pink-hued building sits on the bank of the Buriganga River and now serves as a museum showcasing the region's Nawabi history."
        ),
        DhakaPlace(
            image = R.drawable.star_mosque,
            title = "Star Mosque",
            subtitle = "Tara Masjid",
            description = "A stunning mosque in Old Dhaka decorated with intricate star-patterned mosaic tiles and Japanese and English china clay tiles, blending Mughal architecture with unique decorative art."
        ),
        DhakaPlace(
            image = R.drawable.national_parlament,
            title = "National Parliament House",
            subtitle = "Jatiyo Sangsad Bhaban",
            description = "Designed by architect Louis Kahn, this modernist masterpiece houses the Parliament of Bangladesh and is considered one of the largest legislative complexes in the world."
        ),
        DhakaPlace(
            image = R.drawable.national_martyrs_memorial,
            title = "National Martyrs' Memorial",
            subtitle = "Jatiyo Smriti Soudho",
            description = "Located in Savar, this striking memorial honors the martyrs of the 1971 Bangladesh Liberation War with its distinctive stepped tower design surrounded by mass graves and lakes."
        ),
        DhakaPlace(
            image = R.drawable.dhakeshwari_temple,
            title = "Dhakeshwari Temple",
            subtitle = "National temple of Bangladesh",
            description = "The most important Hindu temple in Bangladesh, dedicated to the goddess Durga. Its name is believed to have inspired the city's name, Dhaka."
        ),
        DhakaPlace(
            image = R.drawable.sadarghat,
            title = "Sadarghat",
            subtitle = "River port of Old Dhaka",
            description = "A bustling and historic river terminal on the Buriganga River, offering a glimpse into the daily life, trade, and chaos of one of the busiest inland ports in the world."
        ),
        DhakaPlace(
            image = R.drawable.liberation_war_museum,
            title = "Liberation War Museum",
            subtitle = "History of independence",
            description = "A museum dedicated to preserving the history of the 1971 Bangladesh Liberation War through photographs, documents, weapons, and personal artifacts from the era."
        ),
        DhakaPlace(
            image = R.drawable.national_museum,
            title = "Bangladesh National Museum",
            subtitle = "Largest museum in Bangladesh",
            description = "Home to a vast collection of artifacts spanning art, history, natural history, and ethnography, offering a comprehensive look into the country's heritage."
        ),
        DhakaPlace(
            image = R.drawable.botanical_garden,
            title = "National Botanical Garden",
            subtitle = "Green escape in Mirpur",
            description = "A sprawling garden home to thousands of plant species, greenhouses, and a lake, offering a peaceful retreat from the busy streets of Dhaka."
        )
    )
}