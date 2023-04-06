package ru.nsu.ccfit.verba.verbaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "word", schema = "verba", catalog = "db")
public class WordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "word", nullable = false, length = 255)
    private String word;
    @Basic
    @Column(name = "transcription", nullable = false, length = 255)
    private String transcription;
    @Basic
    @Column(name = "type_word", nullable = false)
    private int typeWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public int getTypeWord() {
        return typeWord;
    }

    public void setTypeWord(int typeWord) {
        this.typeWord = typeWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordEntity that = (WordEntity) o;

        if (id != that.id) return false;
        if (typeWord != that.typeWord) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        if (transcription != null ? !transcription.equals(that.transcription) : that.transcription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (transcription != null ? transcription.hashCode() : 0);
        result = 31 * result + typeWord;
        return result;
    }
}
