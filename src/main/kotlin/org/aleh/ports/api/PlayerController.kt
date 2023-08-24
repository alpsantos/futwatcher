package org.aleh.ports.api


import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.aleh.applicationservices.dtos.PlayerRequestDto
import org.aleh.applicationservices.player.CreatePlayerServices
import org.aleh.applicationservices.player.GetPlayerServices
import org.aleh.domain.Player

@Path("api/")
class PlayerController
@Inject
constructor(
    private val getPlayerServices: GetPlayerServices,
    private val createPlayerServices : CreatePlayerServices

) {
    @Path("/player")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPlayer(@QueryParam("id") id: Int): Response? {
        val response = getPlayerServices.getPlayer(id)
        return if (response != null)
            Response.status(Response.Status.OK).entity(response).build()
        else
            Response.status(Response.Status.NOT_FOUND).build()
    }

    @Path("/player")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun createPlayer(request: PlayerRequestDto): Response {
        return try {
            createPlayerServices.createPlayer(request.id)
            Response.status(Response.Status.CREATED).build()
        } catch (e: Exception) {
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
        }
    }
}