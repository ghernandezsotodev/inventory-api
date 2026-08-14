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

    @PutMapping("/{id}")
    public Server updateServer(@PathVariable Long id, @RequestBody Server serverDetails){
        Server existingServer = serverRepository.findById(id).orElse(null);
        if(existingServer != null){
            existingServer.setName(serverDetails.getName());
            existingServer.setIpAddress(serverDetails.getIpAddress());
            existingServer.setOs(serverDetails.getOs());
            existingServer.setStatus(serverDetails.getStatus());
            return serverRepository.save(existingServer);
        }
        return null;
    }
}
