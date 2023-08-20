package org.aleh.ports.api


import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.aleh.applicationservices.player.GetPlayerServices

@Path("api/")
class PlayerController
@Inject
constructor(
    private val getPlayerServices: GetPlayerServices

) {
    @Path("/player")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPlayer(@QueryParam("id") id: Int): Response? {
        val player = getPlayerServices.getPlayer(id)
        return if (player != null)
            Response.status(Response.Status.OK).entity(player).build()
        else
            Response.status(Response.Status.NOT_FOUND).build()
    }
}