package ru.nsu.ccfit.verba.verbaapi.domain

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import jakarta.persistence.*
import java.time.OffsetDateTime

data class StatusCard(
    var stages: Long = 0,
    var repetitionDate: OffsetDateTime = OffsetDateTime.now()
) {
    // default constructor
    constructor() : this(0, OffsetDateTime.now())
}

@Entity
@Table(name = "allow_user_group")
class AllowUserGroup(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    @ManyToOne
    val user: User,

    @ManyToOne
    val group: GroupCatalog,

    val accessRead: Boolean,

    val accessChanges: Boolean,

    @Convert(converter = StatusCardConverter::class)
    @Column(columnDefinition = "jsonb")
    var statusCards: HashMap<Long, StatusCard>,

    @ManyToOne
    val tactic: Tactics
)

@Converter
class StatusCardConverter : AttributeConverter<HashMap<Long, StatusCard>, String> {

    private val objectMapper = ObjectMapper().registerModule(JavaTimeModule())

    override fun convertToDatabaseColumn(attribute: HashMap<Long, StatusCard>): String {
        return objectMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): HashMap<Long, StatusCard> {
        val typeReference = object : TypeReference<HashMap<Long, StatusCard>>() {}
        return objectMapper.readValue(dbData, typeReference)
    }
}


