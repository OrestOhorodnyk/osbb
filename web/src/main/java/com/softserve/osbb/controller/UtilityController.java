package com.softserve.osbb.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.softserve.osbb.model.Utility;
import com.softserve.osbb.service.UtilityService;

@RestController
@CrossOrigin
@RequestMapping(value = "/restful/utility")
public class UtilityController {

	private static final List<Resource<Utility>> EMPTY_LIST = new ArrayList<>(0);

	private static final Logger logger = LoggerFactory.getLogger(UtilityController.class);
	
	@Autowired
	private UtilityService utilityService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Resource<Utility>>> getAll() {
		logger.info("Get all utilities.....");
		List<Utility> utilities = utilityService.getAll();
		List<Resource<Utility>> resources = new ArrayList<Resource<Utility>>();

		if (utilities.isEmpty()) {
			return new ResponseEntity<>(EMPTY_LIST, HttpStatus.OK);
		} else {
			for (Utility temp : utilities) {
				resources.add(getUtilityResource(temp));
			}
			return new ResponseEntity<>(resources, HttpStatus.OK);

		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Resource<Utility>> create(@RequestBody Utility utility) {
		logger.info("Save utility.....");
        Utility resource = utilityService.save(utility);
        return new ResponseEntity<>(getUtilityResource(resource), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Resource<Utility>> updateRole(@RequestBody Utility utility) {
		logger.info("Update utility....." + utility);
        Utility updatedUtility = utilityService.updateUtility(utility);
        return new ResponseEntity<>(getUtilityResource(updatedUtility), HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource<Utility>> getById(@PathVariable(value = "id") Integer id) {
		logger.info("Find utility by id: " + id);
		Utility utility = utilityService.findById(id);
		return new ResponseEntity<>(getUtilityResource(utility), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Resource<Utility>> deleteUtility(@PathVariable("id") Integer id) {
		
		logger.info("Delete utility with id: " + id);
        utilityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Resource<Utility> getUtilityResource(Utility utility) {
        if (utility == null) {
            return null;
        }
        
        Resource<Utility> resource = new Resource<>(utility);
        resource.add(linkTo(methodOn(UtilityController.class)
                .getById(utility.getUtilityId()))
                .withSelfRel());
        return resource;
    }

}