package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContatos {
    private List<Contato> contacts;
    private int nextId;

    // Constructor
    public GerenciadorContatos() {
        this.contacts = new ArrayList<Contato>();
        nextId = 1;
    }

    // CRUD methods
    public void addContact(Contato contact) {
        contact.setId(nextId++);
        this.contacts.add(contact);
    }

    public List<Contato> getAllContacts() {
        return new ArrayList<Contato>(this.contacts); // return copy to avoid external modify
    }

    public Contato getContact(int id) {
        for (Contato contact : this.contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        System.out.println("Error: Invalid ID");
        return null;
    }

    public void refreshContact(Contato refreshedContact) {
        for (Contato contact : this.contacts) {
            if (contact.getId() == refreshedContact.getId()) {
                this.removeContact(contact.getId());
                this.contacts.add(refreshedContact);
                return;
            }
        }
    }

    public void removeContact(int id) {
        Contato contact = this.getContact(id);
        this.contacts.remove(contact);
    }

}
