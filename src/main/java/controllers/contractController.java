package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lito.angular.angularP.models.*;

import com.lito.angular.angularP.repositories.*;


@RestController
public class contractController {
	
	@Autowired
    ContactRepository contactRepository;	
	
	@RequestMapping(method=RequestMethod.GET, value="/contacts")
    public Iterable<contact> contact() {
        return contactRepository.findAll();
    }
	
    @RequestMapping(method=RequestMethod.POST, value="/contacts")
    public contact save(@RequestBody contact contact) {
        contactRepository.save(contact);

        return contact;
    }

    @RequestMapping(method=RequestMethod.GET, value="/contacts/{id}")
    public contact show(@PathVariable String id) {
        return contactRepository.findOne(id);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
    public contact update(@PathVariable String id, @RequestBody contact contact) {
        contact c = contactRepository.findOne(id);
        if(contact.getName() != null)
            c.setName(contact.getName());
        if(contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            c.setCity(contact.getCity());
        if(contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactRepository.save(c);
        return contact;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
    public String delete(@PathVariable String id) {
        contact contact = contactRepository.findOne(id);
        contactRepository.delete(contact);

        return "";
    }
	
	
	

}
