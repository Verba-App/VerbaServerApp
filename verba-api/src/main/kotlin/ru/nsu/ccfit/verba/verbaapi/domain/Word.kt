package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*

enum class WordType {
    VERB,
    NOUN
}

@Entity
@Table(name = "word")
class Word(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    val text: String,

    val transcription: String,

    @Enumerated(EnumType.STRING)
    val type: WordType,

    @ManyToMany
    @JoinTable(
        name = "category_word",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "word_id")]
    )
    var categories: Set<Category>,
)