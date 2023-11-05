package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Role;

public interface RoleService {

    public Role createRole(Role role);

    public Role getRoleById(Long roleId);

    public List<Role> getAllRoles();

    public Role updateRole(Role role);

    public void deleteRole(Long roleId);
}