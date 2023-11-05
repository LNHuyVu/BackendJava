package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Role;
import com.example.example3.service.RoleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/role")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role savedRole = roleService.createRole(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long roleId) {
        Role role = roleService.getRoleById(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> Roles = roleService.getAllRoles();
        return new ResponseEntity<>(Roles, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Long roleId,
            @RequestBody Role Role) {
        Role.setId(roleId);
        Role upRole = roleService.updateRole(Role);
        return new ResponseEntity<>(upRole, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>("Role delete OK", HttpStatus.OK);
    }
}