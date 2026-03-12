import { useProfile } from '../hooks/useAssessments'
import { Flame } from 'lucide-react'

export function HomePage() {
  const { data: profile } = useProfile()

  return (
    <div className="pt-12">
      <h1 className="text-2xl font-bold text-text">
        Hey, {profile?.name || 'Climber'}
      </h1>
      <p className="text-text-secondary mt-1">Ready to train?</p>

      {profile && (
        <div className="mt-6 bg-card rounded-2xl p-5 shadow-sm">
          <div className="flex items-center gap-3">
            <div className="w-12 h-12 bg-orange-100 rounded-full flex items-center justify-center">
              <Flame className="w-6 h-6 text-orange-500" />
            </div>
            <div>
              <div className="text-2xl font-bold text-text">{profile.streakDays}</div>
              <div className="text-xs text-text-secondary">Day streak</div>
            </div>
          </div>
        </div>
      )}

      <div className="mt-6 bg-card rounded-2xl p-5 shadow-sm">
        <h2 className="text-sm font-semibold text-text mb-2">Quick Stats</h2>
        <p className="text-xs text-text-secondary">
          Body Weight: {profile?.bodyWeightKg ?? '—'} kg
        </p>
      </div>
    </div>
  )
}
