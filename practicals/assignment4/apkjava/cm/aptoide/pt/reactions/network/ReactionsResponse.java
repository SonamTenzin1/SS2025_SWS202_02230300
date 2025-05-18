package cm.aptoide.pt.reactions.network;

import retrofit2.Response;

/* loaded from: classes.dex */
public class ReactionsResponse {
    private final ReactionResponseMessage reactionResponseMessage;

    /* loaded from: classes.dex */
    public static class ReactionResponseMapper {
        public static ReactionResponseMessage mapReactionResponse(Response response) {
            ReactionResponseMessage reactionResponseMessage = ReactionResponseMessage.GENERAL_ERROR;
            int code = response.code();
            if (code == 200 || code == 201 || code == 204) {
                return ReactionResponseMessage.SUCCESS;
            }
            if (code == 403) {
                return reactionResponseMessage;
            }
            if (code != 429) {
                return (code == 500 || code == 400 || code == 401 || code != 405) ? reactionResponseMessage : reactionResponseMessage;
            }
            return ReactionResponseMessage.REACTIONS_EXCEEDED;
        }
    }

    /* loaded from: classes.dex */
    public enum ReactionResponseMessage {
        SUCCESS,
        GENERAL_ERROR,
        REACTIONS_EXCEEDED,
        SAME_REACTION,
        NETWORK_ERROR
    }

    public ReactionsResponse(ReactionResponseMessage reactionResponseMessage) {
        this.reactionResponseMessage = reactionResponseMessage;
    }

    public boolean differentReaction() {
        return this.reactionResponseMessage != ReactionResponseMessage.SAME_REACTION;
    }

    public boolean reactionsExceeded() {
        return this.reactionResponseMessage == ReactionResponseMessage.REACTIONS_EXCEEDED;
    }

    public boolean wasGeneralError() {
        return this.reactionResponseMessage == ReactionResponseMessage.GENERAL_ERROR;
    }

    public boolean wasNetworkError() {
        return this.reactionResponseMessage == ReactionResponseMessage.NETWORK_ERROR;
    }

    public boolean wasSuccess() {
        return this.reactionResponseMessage == ReactionResponseMessage.SUCCESS;
    }
}
