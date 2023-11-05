package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Role;
import com.example.example3.repository.RoleRespository;
import com.example.example3.service.RoleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRespository roleRespository;

    @Override
    public Role createRole(Role role) {
        return roleRespository.save(role);
    }

    @Override
    public Role getRoleById(Long roleId) {
        Optional<Role> optionalRole = roleRespository.findById(roleId);
        return optionalRole.get();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRespository.findAll();
    }

    // Not update email and password
    @Override
    public Role updateRole(Role role) {
        Role existingRole = roleRespository.findById(role.getId()).get();
        existingRole.setName(role.getName());
        Role updatedRole = roleRespository.save(existingRole);
        return updatedRole;
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRespository.deleteById(roleId);
    }
}
