/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.elridge.sudoku.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author varun
 */
@Entity
@Table(name = "score", catalog = "game", schema = "")
@NamedQueries({
    @NamedQuery(name = "Score.findAll", query = "SELECT s FROM Score s")
    , @NamedQuery(name = "Score.findBySno", query = "SELECT s FROM Score s WHERE s.sno = :sno")
    , @NamedQuery(name = "Score.findByEmail", query = "SELECT s FROM Score s WHERE s.email = :email")
    , @NamedQuery(name = "Score.findByScore", query = "SELECT s FROM Score s WHERE s.score = :score")
    , @NamedQuery(name = "Score.findByPosition", query = "SELECT s FROM Score s WHERE s.position = :position")})
public class Score implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "sno")
    private int sno;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "score")
    private int score;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public Score() {
    }

    public Score(String email) {
        this.email = email;
    }

    public Score(String email, int sno, int score, int position) {
        this.email = email;
        this.sno = sno;
        this.score = score;
        this.position = position;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        int oldSno = this.sno;
        this.sno = sno;
        changeSupport.firePropertyChange("sno", oldSno, sno);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        int oldScore = this.score;
        this.score = score;
        changeSupport.firePropertyChange("score", oldScore, score);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        int oldPosition = this.position;
        this.position = position;
        changeSupport.firePropertyChange("position", oldPosition, position);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nl.elridge.sudoku.view.Score[ email=" + email + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
