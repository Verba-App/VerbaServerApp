package ru.nsu.ccfit.verba.verbaapi.domain

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.*

@Entity
@Table(name = "tactics")
class Tactics(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,
    val name: String,

    @Convert(converter = JsonListStagesConverter::class)
    @Column(columnDefinition = "jsonb")
    var stages: List<StageStudy>,

    @ManyToOne
    val author: User
)

class JsonListStagesConverter : AttributeConverter<List<StageStudy>, String> {

    private val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: List<StageStudy>): String {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): List<StageStudy> {
        return objectMapper.readValue(
            dbData,
            objectMapper.typeFactory.constructCollectionType(List::class.java, StageStudy::class.java)
        )
    }
}

data class StageStudy(
    val name: String,
    val countDay: Int
)
