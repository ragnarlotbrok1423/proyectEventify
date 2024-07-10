package com.dev.eventify.entities.models

data class Facultades(
    var nombreFacultad: String,
    var imagen: String?,
)

fun getListOfFacultades(): List<Facultades> {
    return listOf(
        Facultades(
            nombreFacultad = "Facultad de Ingeniería Civil",
            imagen = "https://fic.utp.ac.pa/sites/fic.utp.ac.pa/files/logo_fic_0.gif"
        ),
        Facultades(
            nombreFacultad = "Facultad de Ingeniería Eléctrica",
            imagen = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgEeGFAx9I1dwfvXYBDAm0oo98VtmOYFyJprBikwodr0eq449qi4kvJoR6C1fwq6oANY8Zp_g9nbdxSkgB9hpGq9pC0oRTEVaEEr27tfn1xYUVkLj84SFZhZ5UITRThlehPdAWNaqXPAj0/s1600/logo_fie.gif"
        ),
        Facultades(
            nombreFacultad = "Facultad de Ingeniería Industrial",
            imagen = "https://fii.utp.ac.pa/sites/all/themes/custom/sub_facultad/tropical_fii/logo.png"
        ),
        Facultades(
            nombreFacultad = "Facultad de Ingeniería Mecánica",
            imagen = "https://fim.utp.ac.pa/sites/fim.utp.ac.pa/files/facultad-de-mecanica_0.gif"
        ),
        Facultades(
            nombreFacultad = "Facultad de Ingeniería de Sistemas Computacionales",
            imagen = "https://fisc.utp.ac.pa/sites/fisc.utp.ac.pa/files/documentos/2020/imagen/logo_en_contactenos.png"
        ),
        Facultades(
            nombreFacultad = "Facultad de Ciencias y Tecnología",
            imagen = "https://fct.utp.ac.pa/sites/all/themes/custom/sub_facultad/tropical_fct/logo.png"
        )
    )
}