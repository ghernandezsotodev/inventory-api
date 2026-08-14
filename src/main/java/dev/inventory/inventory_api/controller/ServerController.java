package dev.inventory.inventory_api.controller;

import dev.inventory.inventory_api.model.Server;
import dev.inventory.inventory_api.repository.ServerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerRepository serverRepository;

    public ServerController(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @PostMapping
    public Server createServer(@RequestBody Server server){
        return serverRepository.save(server);
    }

    @GetMapping
    public List<Server> getAllServers(){
        return serverRepository.findAll();
    }

    @GetMapping("/{id}")
    public Server getServerById(@PathVariable Long id){
        return serverRepository.findById(id).orElse(null);
    }
}
